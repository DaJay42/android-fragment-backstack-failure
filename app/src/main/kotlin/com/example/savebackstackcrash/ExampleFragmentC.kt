package com.example.savebackstackcrash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import kotlin.reflect.jvm.jvmName

class ExampleFragmentC: Fragment() {

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
		ComposeView(inflater.context).apply {
			setContent {
				CreateContent()
			}
		}

	@Composable
	private fun CreateContent() {
		var canClickButton by remember { mutableStateOf(true) }
		Text("Fragment C", Modifier.padding(4.dp))
		Box(contentAlignment = Alignment.Center) {
			TextButton(
				onClick = {
					canClickButton = false
					saveBackStack()
				},
				enabled = canClickButton
			) {
				Text("Save BackStack")
			}
		}
	}

	private fun saveBackStack() {
		requireActivity().supportFragmentManager.saveBackStack(ExampleFragmentA::class.jvmName)
		requireActivity().supportFragmentManager.commit {
			setReorderingAllowed(true)
			add(R.id.topContent, ExampleFragmentA::class.java, null)
			addToBackStack(ExampleFragmentA::class.jvmName)
		}
	}
}