using UnityEngine;
using System.Collections;

public class CameraMove3 : MonoBehaviour {

	Transform player;
	PlayerFSM _playerFSM;
	Transform finish;
	Transform camera;

	void Awake()
	{
		player = GameObject.FindGameObjectWithTag("Player").transform;
		finish = GameObject.FindGameObjectWithTag ("Finish").transform;
		camera = GameObject.FindGameObjectWithTag ("MainCamera").transform;
		_playerFSM = GameObject.FindGameObjectWithTag("Player").GetComponent<PlayerFSM>();
	}

	void LateUpdate()
	{
		if(_playerFSM.score >= 500)
		{
			camera.position = finish.position;
			camera.rotation = finish.rotation;
		}
		else
		{
			transform.position = player.position;
			transform.rotation = Quaternion.Slerp(transform.rotation, player.rotation, Time.deltaTime * 2f);	//카메라 회전 보간
		}
	}
}
