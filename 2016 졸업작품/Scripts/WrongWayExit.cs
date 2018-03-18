using UnityEngine;
using System.Collections;

public class WrongWayExit : MonoBehaviour {

	PlayerFSM _playerFSM;
	GameObject text;	
	GameObject killzone;
	GameObject cabinet;

	void Awake()
	{
		text = GameObject.FindGameObjectWithTag ("Text");
		killzone = GameObject.FindGameObjectWithTag ("KillZone");
		cabinet = GameObject.FindGameObjectWithTag ("Cabinet");
	}

    void OnTriggerEnter(Collider other)
    {
		if (other.gameObject.CompareTag("Player"))		
        {   
			text.SetActive (false);
			killzone.SetActive (false);
			cabinet.SetActive (false);
        }       
    }
}
