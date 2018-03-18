using UnityEngine;
using System.Collections;
using UnityEngine.UI;
using UnityEngine.SceneManagement;

public class GameStart : MonoBehaviour
{
	public string nextScene;	// nextScene -> 넘어갈 다음 씬을 전해 받는 변수

	public void Game_Start()
	{
		SceneManager.LoadScene (nextScene);		//nextScene이라는 이름을 가진 씬을 로드 하며 씬 이름은 유니티 내에서 입력
	}
}