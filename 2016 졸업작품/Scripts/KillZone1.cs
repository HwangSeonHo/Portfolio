using UnityEngine;
using System.Collections;

public class KillZone1 : MonoBehaviour {

	PlayerFSM _playerFSM;
	GameObject cabinet;

	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
		cabinet = GameObject.FindGameObjectWithTag ("Cabinet");

	}

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Player"))		// 캐비닛 넘어지는 영역 도달시 데미지를 입고 패배
		{
			_playerFSM. Damage();
        }       
    }
}
