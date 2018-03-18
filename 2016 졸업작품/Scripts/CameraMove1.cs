using UnityEngine;
using System.Collections;

public class CameraMove1 : MonoBehaviour {
    
    Transform player;

    void Awake()
    {
        player = GameObject.FindGameObjectWithTag("Player").transform;	//Player 태그와 위치를 가져옴
    }

    void LateUpdate()
    {
        transform.position = player.position;	//옵젝트의 위치를 Player와 같게 변경
    }
}
