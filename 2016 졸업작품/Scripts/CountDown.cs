using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class CountDown : MonoBehaviour
{
	public float coolTime = 3.0f;
	public Text leftTime;
	CameraShake _CameraShake;
	PlayerFSM _playerFSM;
	
	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
		_CameraShake = GameObject.FindGameObjectWithTag("CameraRig").GetComponent<CameraShake>();
	}
	
	void Update()
	{
		if (coolTime > 0f)
		{			
			float temp = coolTime;
			coolTime -= _playerFSM.freeze * Time.deltaTime;		// 시간이 줄어듬, 멈춤 변수가 0이면 시간 멈춤
			if (temp % 10 < 1 && _playerFSM.freeze == 1) {		// 카운트를 10으로 나눈 나머지가 0~1일때 Shake
				_CameraShake.ShakeCamera ();
				if (_playerFSM.state != (CharacterState.HIDE)) {		// 흔드는 도중 숨기를 안했으면 데미지
					_playerFSM.Damage ();		
				}
			}

			leftTime.text = string.Format("{0:0}", temp);       // 숫자, 한자리
		}
		else
		{
			leftTime.gameObject.SetActive(false);		// 남은시간을 끄고 패배
			_playerFSM. Loss();
		}
	}
	
	public void Count_Down()
	{
			leftTime.gameObject.SetActive(true);        // 남은 시간 보여 주기
	}
}
