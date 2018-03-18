using UnityEngine;
using System.Collections;
using UnityEngine.EventSystems;
using UnityEngine.SceneManagement;

public class PlayerFSM : FSMBase {

	public int moveSpeed;
	public string lossScene;
	public string winScene;
	GameObject movePoint;		// 이동 커서 오브젝트
	GameObject attackPoint;		// 특수 이동 커서 오브젝트
	LayerMask layerMask;		// 레이어 변수
	GameObject fan;				// 낙하물 오브젝트
	GameObject cabinet;			// 캐비닛 오브젝트
	GameObject consent;	
	public int freeze = 1;		// 카메라 흔들기 멈추는 변수

	GameObject effect;	
	GameObject mission1;	
	GameObject mission2;	
	GameObject mission3;	
	GameObject door;
	GameObject killzone3;
	public int score = 0;

	AudioSource pickSound;
	GameObject hitBG;
    	
    public override void Awake()        // 부모와 함수가 똑같으므로 재정의 해야함
	{		
		movePoint = GameObject.FindGameObjectWithTag("MovePoint");
		movePoint.SetActive(false);		// 이동 커서 비활성화
		attackPoint = GameObject.FindGameObjectWithTag("Point");
		attackPoint.SetActive(false);	// 특수 이동 커서 비활성화
		fan = GameObject.FindGameObjectWithTag ("Fan");
		cabinet = GameObject.FindGameObjectWithTag ("Cabinet");
		consent = GameObject.FindGameObjectWithTag ("Consent");

		effect = GameObject.FindGameObjectWithTag ("Effect");
		mission1 = GameObject.FindGameObjectWithTag ("Mission1");
		mission2 = GameObject.FindGameObjectWithTag ("Mission2");
		mission3 = GameObject.FindGameObjectWithTag ("Mission3");
		door = GameObject.FindGameObjectWithTag ("Door");
		effect.SetActive (false);
		mission1.SetActive (false);
		mission2.SetActive (false);
		mission3.SetActive (false);
		killzone3 = GameObject.FindGameObjectWithTag ("KillZone3");

		pickSound = GetComponent<AudioSource>();
		hitBG = GameObject.FindGameObjectWithTag ("HitBG");
 
		base.Awake();	// FSMBase Awake 실행
        layerMask = LayerMask.GetMask("Click", "Block", "Hide", "UI");	// 클릭 가능/불가능 숨기지역 레이어를 가져옴
	}

    public void UseACTION1()
	{
		movePoint.SetActive(false);
		pickSound.Play();
		SetState (CharacterState.ACTION1);		// 이벤트 모션
    }

	public void UseACTION2()
	{
		movePoint.SetActive(false);
		pickSound.Play();
		SetState (CharacterState.ACTION2);		// 점프 모션
	}

	public void Hide()
	{
		movePoint.SetActive(false);				// 숨기 모션
		SetState (CharacterState.HIDE);
	}

	public void Damage()
	{
		movePoint.SetActive(false);				// 피해 모션
		hitBG.GetComponent<AudioSource> ().Play ();
		SetState (CharacterState.DAMAGE);
	}

	public void Loss()
	{
		movePoint.SetActive(false);				// 패배 모션
		SetState (CharacterState.LOSE);
	}

	void Update()
	{    
		if(Input.GetMouseButtonDown(0))			// 마우스가 클릭 될때
		{
			Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition);	// 카메라에서 마우스 위치로 광선이 나감
			RaycastHit hitInfo;

            if (Physics.Raycast(ray, out hitInfo, 100.0f, layerMask))
			{				
                int layer = hitInfo.collider.gameObject.layer;		// 광선이 닿은 곳의 레이어 확인
								
				if ((layer == LayerMask.NameToLayer("Click")) 
					&& (state != (CharacterState.DAMAGE)) 
					&& (state != (CharacterState.HIDE)) 
					&& (state != (CharacterState.LOSE))
					&& (layer != LayerMask.NameToLayer("UI")))	// 클릭이 가능하고 특수 행동중이 아닐 때
                {
                    movePoint.transform.position = hitInfo.point;	// 이동 커서를 클릭한 곳에 발생 시킴
                    movePoint.SetActive(true);						// 이동 커서 활성화
                    SetState(CharacterState.RUN);					// 캐릭터 달리기 시작
				}

				if ((layer == LayerMask.NameToLayer("Hide")) )
				{
					movePoint.SetActive(false);			
					attackPoint.SetActive(true);					// 특수 이동 커서 활성화
					SetState(CharacterState.HIDERUN);
				}
			}
		}
	}

    IEnumerator RUN()
    {
        do
        {
            yield return null;

			effect.SetActive(false);

			if (MoveUtil.MoveFrame(cc, movePoint.transform, moveSpeed,1000) == 0)		// 2의 movespeed 1000의 turnspeed로 movepoint까지 이동되면
            {
                SetState(CharacterState.REFLESH);		// 도착 후 REFLESH 상태로
                movePoint.SetActive(false);				
            }

        } while(state == CharacterState.RUN);
    }

    IEnumerator ACTION1()
    {
        //Entry
        do
        {
            yield return null;
            //Process

			if (Vector3.Distance(transform.position, consent.transform.position) <= 0.4f)		// 캐릭터와 커서 거리가 0.5 이하가 되면
			{
				effect.SetActive(true);

				score++;
				mission1.SetActive(true);
			}	

			if (Vector3.Distance(transform.position, door.transform.position) <= 1f)		// 캐릭터와 커서 거리가 0.5 이하가 되면
			{
				if(score > 90)
				{
					freeze = 0;
					effect.SetActive(true);

					SetState(CharacterState.Win);
					door.SetActive(false);
				}
			}

			if (Vector3.Distance(transform.position, killzone3.transform.position) <= 1f)		// 캐릭터와 커서 거리가 0.5 이하가 되면
			{
				if(state == CharacterState.ACTION1)
				{
					freeze = 0;
					SetState(CharacterState.LOSE);
				}
			}

            if((a.GetCurrentAnimatorStateInfo(0).normalizedTime % 1.0f) > 0.9f       //애니메이션이 90프로 이상 완료 되면 (루프시 0.9 1.9 2.9)
                && a.GetCurrentAnimatorStateInfo(0).IsName("ACTION1"))     
            {
                SetState(CharacterState.REFLESH);
				effect.SetActive(false);
                break;
            }

        } while(state == CharacterState.ACTION1);
        //Exit
    }

	IEnumerator ACTION2()
	{
		//Entry
		do
		{
			yield return null;
			//Process

			if (Vector3.Distance(transform.position, cabinet.transform.position) <= 1f)		// 캐릭터와 커서 거리가 0.5 이하가 되면
			{
				effect.SetActive(true);

				score++;
				mission2.SetActive(true);
				freeze = 1;
			}	

			if (Vector3.Distance(transform.position, fan.transform.position) <= 3f)		// 캐릭터와 커서 거리가 0.5 이하가 되면
			{
				effect.SetActive(true);

				score++;
				mission3.SetActive(true);
				freeze = 1;
			}	

			if((a.GetCurrentAnimatorStateInfo(0).normalizedTime % 1.0f) > 0.9f       
				&& a.GetCurrentAnimatorStateInfo(0).IsName("ACTION2"))     
			{
				effect.SetActive(false);
				SetState(CharacterState.REFLESH);
				break;
			}

		} while(state == CharacterState.ACTION2);
		//Exit
	}

	IEnumerator DAMAGE()
	{
		freeze = 0;
		//Entry
		do
		{
			yield return null;
			//Process
			if (Vector3.Distance(transform.position, fan.transform.position) <= 4f)		
			{
				fan.transform.Translate (new Vector3(0, 0, -2.8f)*Time.deltaTime);		// 낙하물이 떨어짐
			}																		

			if (Vector3.Distance(transform.position, cabinet.transform.position) <= 1f)		
			{
				cabinet.transform.Rotate(new Vector3(85.0f, 0f, 0f)*Time.deltaTime);	// 캐비닛이 넘어짐
			}	

			if((a.GetCurrentAnimatorStateInfo(0).normalizedTime % 1.0f) > 0.8f
				&& a.GetCurrentAnimatorStateInfo(0).IsName("DAMAGE"))     
			{
				SetState(CharacterState.LOSE);
				break;
			}

		} while(state == CharacterState.DAMAGE);
		//Exit
	}

	IEnumerator HIDE()
	{
		//Entry

		do
		{
			yield return null;
			//Process

			if((a.GetCurrentAnimatorStateInfo(0).normalizedTime % 1.0f) > 0.5f
				&& a.GetCurrentAnimatorStateInfo(0).IsName("HIDE"))     
			{
				SetState(CharacterState.HIDE);
				break;
			}

		} while(state == CharacterState.HIDE);
		//Exit
	}

	IEnumerator HIDERUN()
	{
		//Entry
		do
		{
			yield return null;
			//Process

			MoveUtil.MoveFrame(cc, attackPoint.transform, 3,1000);		//3의 movespeed 1000의 turnspeed로 attackpoint까지 이동

			if (Vector3.Distance(transform.position, attackPoint.transform.position) <= 0.6f)		// 캐릭터와 커서 거리가 0.5 이하가 되면
			{
				SetState(CharacterState.HIDE);		// 도착 후 숨기 상태로
				attackPoint.SetActive(false);
			}		

		} while(state == CharacterState.HIDERUN);
		//Exit
	}

	IEnumerator LOSE()
	{
		//Entry
		freeze = 0;
		do
		{
			yield return null;
			//Process

			if((a.GetCurrentAnimatorStateInfo(0).normalizedTime % 1.0f) > 0.9f       //애니메이션이 90프로 이상 완료 되면 (루프시 0.9 1.9 2.9)
				&& a.GetCurrentAnimatorStateInfo(0).IsName("LOSE"))     
			{
				SceneManager.LoadScene (lossScene);		// 패배 씬으로
			}

		} while(state == CharacterState.LOSE);
		//Exit
	}

	IEnumerator Win()
	{
		//Entry
		freeze = 0;
		transform.Rotate(new Vector3(0f, 180f, 0f));

		do
		{
			yield return null;
			//Process

			if((a.GetCurrentAnimatorStateInfo(0).normalizedTime % 1.0f) > 0.8f       //애니메이션이 90프로 이상 완료 되면 (루프시 0.9 1.9 2.9)
				&& a.GetCurrentAnimatorStateInfo(0).IsName("Win"))     
			{
				SceneManager.LoadScene (winScene);		// 승리 씬으로
			}

		} while(state == CharacterState.Win);
		//Exit
	}
}