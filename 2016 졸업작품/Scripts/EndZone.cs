using UnityEngine;
using System.Collections;

public class EndZone : MonoBehaviour {

	PlayerFSM _playerFSM;
	GameObject mission;	

	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
		mission = GameObject.FindGameObjectWithTag ("Mission");
		mission.SetActive (false);
	}

    void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.CompareTag("Player"))		
		{
			_playerFSM.score += 40;
			mission.SetActive (true);
        }       
    }
}
