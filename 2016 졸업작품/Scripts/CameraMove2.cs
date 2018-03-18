using UnityEngine;
using System.Collections;

public class CameraMove2 : MonoBehaviour {
    
    Transform player;

    void Awake()
    {
        player = GameObject.FindGameObjectWithTag("Player").transform;
    }

    void LateUpdate()
    {
        transform.position = player.position;
		transform.rotation = Quaternion.Slerp(transform.rotation, player.rotation, Time.deltaTime * 2f);	//카메라 회전 보간
    }
}
