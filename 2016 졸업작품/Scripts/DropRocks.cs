using UnityEngine;
using System.Collections;

public class DropRocks : MonoBehaviour {

    public GameObject Rock;   //드래그 드롭으로 변수에 옵젝트 매칭 가능
    public float dropTime = 1f;  //미사일 발사 간격의 시간
    float elapsedTime = 0.0f;
    public Transform[] spawnpos;    //배열로 미사일 개수 입력 받을 수 있음 컴포넌트에서 사이즈로 표시 됨

    void Awake()
    {
        InvokeRepeating("Drop", 0, dropTime); // 슛이라는 함수를 0초뒤에 쏴라
    }

    void Drop()
    {
        for(int i= 0; i<spawnpos.Length;++i)
        {
            GameObject.Instantiate(Rock, spawnpos[i].position, spawnpos[i].rotation);     //게임 옵젝트를 복사, spawnpos 기준
        }
    }

//    void Update () 
//    {
//        elapsedTime += Time.deltaTime;
//
//        if (elapsedTime >= shootTime)
//        {
//            for(int i= 0; i<spawnpos.Length;++i)
//            {
//                GameObject.Instantiate(Bullet, spawnpos[i].position, spawnpos[i].rotation);     //게임 옵젝트를 복사, spawnpos 기준
//            }
//            elapsedTime = 0;
//        }  
//    }
}
