package com.example.sxvandroidextensions.extensions.view.layout

import android.os.Build
import android.transition.Transition
import android.view.animation.BaseInterpolator
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet

fun ConstraintLayout.changeView(
    animate: Long? = null,
    animationInterpolator: BaseInterpolator? = null,
    animationStart: ((Transition?) -> Unit)? = null,
    animationEnd: ((Transition?) -> Unit)? = null,
    changeConstraints: ConstraintSet.() -> Unit
) {
    val constraintSet = ConstraintSet()
    constraintSet.clone(this@changeView)
    constraintSet.apply(changeConstraints).apply {

        if (animate != null) {
            val transition = android.transition.AutoTransition().apply {
                duration = animate
                if (animationInterpolator != null)
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1) {
                        interpolator = animationInterpolator
                    }
                addListener(object : Transition.TransitionListener {
                    override fun onTransitionStart(transition: Transition?) {
                        animationStart?.invoke(transition)
                    }

                    override fun onTransitionEnd(transition: Transition?) {
                        animationEnd?.invoke(transition)
                    }

                    override fun onTransitionResume(transition: Transition?) {}

                    override fun onTransitionPause(transition: Transition?) {}

                    override fun onTransitionCancel(transition: Transition?) {}
                })
            }
            android.transition.TransitionManager.beginDelayedTransition(this@changeView, transition)
        }

        applyTo(this@changeView)
    }

}