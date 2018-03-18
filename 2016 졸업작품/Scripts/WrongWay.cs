using UnityEngine;
using System.Collections;

public class WrongWay : MonoBehaviour {

	PlayerFSM _playerFSM;
	GameObject text;	
	GameObject wrongwayexit;

	void Awake()
	{
		text = GameObject.FindGameObjectWithTag ("Text");
		text.SetActive (false);
		wrongwayexit = GameObject.FindGameObjectWithTag ("WrongWayExit");
		wrongwayexit.SetActive (false);
	}

    void OnTriggerEnter(Collider other)
    {
		if (other.gameObject.CompareTag("Player"))		
        {   
			text.SetActive (true);
			wrongwayexit.SetActive (true);
        }       
    }
		
}
