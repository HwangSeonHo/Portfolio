using UnityEngine;
using System.Collections;
using UnityEngine.UI;

public class ActionButton2 : MonoBehaviour
{
	PlayerFSM _playerFSM;
	
	void Awake()
	{
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
	}

	public void Action()
	{
		_playerFSM. UseACTION2();
	}
}