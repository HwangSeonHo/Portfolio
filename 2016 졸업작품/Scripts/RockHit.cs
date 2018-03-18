using UnityEngine;
using System.Collections;

public class RockHit : MonoBehaviour {

	PlayerFSM _playerFSM;
	GameObject spawnpos;

	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
		spawnpos = GameObject.FindGameObjectWithTag ("SpawnPos");
	}

    void OnTriggerEnter(Collider other)
    {
		if (other.gameObject.CompareTag ("Player")) {		// 낙하물 떨어지는 영역 도달시 데미지를 입고 패배
			_playerFSM. Damage();
			DestroyObject (spawnpos);
		}       
    }
}
