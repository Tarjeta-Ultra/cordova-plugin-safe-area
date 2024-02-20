package me.stevenortiz.cordova

import android.os.Build
import androidx.annotation.RequiresApi
import org.apache.cordova.CallbackContext
import org.apache.cordova.CordovaPlugin
import org.json.JSONArray as JsonArray
import org.json.JSONException as JsonException
import org.json.JSONObject as JsonObject

class SafeArea : CordovaPlugin() {
    @RequiresApi(Build.VERSION_CODES.P)
    @Suppress("UNCHECKED_CAST")
    @Throws(JsonException::class)
    override fun execute(action: String, args: JsonArray, callbackContext: CallbackContext): Boolean {
        when (action) {
            "getSafeAreaInsets" -> {
                callbackContext.success(JsonObject(getSafeAreaInsets() as MutableMap<Any?, Any?>))
                return true
            }
            "getSystemDimensions" -> {
                callbackContext.success(JsonObject(getSystemDimensions() as MutableMap<Any?, Any?>))
                return true
            }
        }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.P)
    fun getSafeAreaInsets(): MutableMap<String, Int> {
        val displayCutout = (
            cordova.activity
                ?.window
                ?.decorView
                ?.rootWindowInsets
                ?.displayCutout
        )
        return mutableMapOf(
            "top" to (displayCutout?.safeInsetTop ?: 0),
            "bottom" to (displayCutout?.safeInsetBottom ?: 0),
            "left" to (displayCutout?.safeInsetLeft ?: 0),
            "right" to (displayCutout?.safeInsetRight ?: 0)
        )
    }

    fun getSystemDimensions(): MutableMap<String, Int> {
        val resources = cordova.activity?.applicationContext?.resources

        val statusBarId = resources?.getIdentifier("status_bar_height", "dimen", "android")
        val navigationBarId = resources?.getIdentifier("navigation_bar_height", "dimen", "android")

        val statusBarHeight = if (statusBarId != null && statusBarId > 0) {
            resources.getDimensionPixelSize(statusBarId)
        } else {
            0
        }
        val navigationBarHeight = if (navigationBarId != null && navigationBarId ?: 0 > 0) {
            resources.getDimensionPixelSize(navigationBarId)
        } else {
            0
        }

        return mutableMapOf(
            "statusBarHeight" to statusBarHeight,
            "navigationBarHeight" to navigationBarHeight
        )
    }
}
