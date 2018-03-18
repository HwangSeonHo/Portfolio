using UnityEngine;
using System.Collections;

public class EndZone2 : MonoBehaviour {

	PlayerFSM _playerFSM;

	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
	}

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Player"))		
		{
			_playerFSM.score += 500;
        }       
    }
}
