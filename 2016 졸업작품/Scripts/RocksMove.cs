using UnityEngine;
using System.Collections;

public class RocksMove : MonoBehaviour {

    public float moveSpeed = 0.4f;
    public float lifeTime = 2.0f;

    void Awake()
    {
        GameObject.Destroy(gameObject, lifeTime);       //만들어지면 자신을 지워라 3초 뒤에
    }

    void Update () 
    {
        transform.Translate(0f, -moveSpeed * Time.deltaTime, 0f);    
    }
}
