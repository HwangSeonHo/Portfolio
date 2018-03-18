using UnityEngine;
using System.Collections;

public class StartShake : MonoBehaviour {

	CameraShake _CameraShake;

	void Awake()
	{
		_CameraShake = GameObject.FindGameObjectWithTag("CameraRig").GetComponent<CameraShake>();		// CameraRig의 Shake 컴포넌트를 가져옴
	}

	public void Shake()
	{
		_CameraShake. ShakeCamera();
	}
}
