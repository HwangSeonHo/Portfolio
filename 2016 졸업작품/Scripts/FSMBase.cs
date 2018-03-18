using UnityEngine;
using System.Collections;

public class FSMBase : MonoBehaviour 
{
	public CharacterState state = CharacterState.REFLESH;	// 캐릭터 초기 상태 = REFLESH

    public CharacterController cc;	

    public Animator a;

	public virtual void Awake() // PlayerFSM에서 재정의 가능
	{       
		cc = GetComponent<CharacterController>();
		a = GetComponentInChildren<Animator>();
     }

    public virtual void OnEnable()
    {
        StartCoroutine(FSMMain());	// 코루틴 시작
    }

    public virtual IEnumerator FSMMain()
    {
        while(true)
        {
            yield return StartCoroutine(state.ToString());
        }
    }
		
    public void SetState(CharacterState newState)
    {
        state = newState;
        a.SetInteger("state",(int)newState);	// 캐릭터 상태를 전달받은 상태로 변경
    }
  
    public virtual IEnumerator REFLESH()
    {
        //Entry
        do
        {
            yield return null;
            //Process

        } while(state == CharacterState.REFLESH);
        //Exit
    }
}