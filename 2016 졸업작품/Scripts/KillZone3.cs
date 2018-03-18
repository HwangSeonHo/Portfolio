using UnityEngine;
using System.Collections;

public class KillZone3 : MonoBehaviour {

	PlayerFSM _playerFSM;
	GameObject text2;

	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
		text2 = GameObject.FindGameObjectWithTag ("Text2");
		text2.SetActive (false);
	}

    void OnTriggerEnter(Collider other)
    {
		if (other.gameObject.CompareTag ("Player")) {		// 낙하물 떨어지는 영역 도달시 데미지를 입고 패배
			text2.SetActive (true);
		}       
    }
}
