package kavalchuk.aliaksandr.belarusnews.Utils

import android.content.Context
import android.content.pm.PackageManager
import android.net.ConnectivityManager


/**
 * Created by user on 31.01.2018.
 */

class UtilsCommon {

    companion object {

        fun getApplicationVersionName(context: Context): String {
            return try {
                val pinfo = context.getPackageManager().getPackageInfo(
                        context.getPackageName(), 0)
                pinfo.versionName
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }

        fun getApplicationPackageName(context: Context): String {
            return try {
                val pinfo = context.packageManager.getPackageInfo(
                        context.packageName, 0)
                pinfo.packageName
            } catch (e: PackageManager.NameNotFoundException) {
                ""
            }
        }

        fun isWifiActive(context: Context): Boolean {
            val cm = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = cm.activeNetworkInfo
            return info != null && info.type == ConnectivityManager.TYPE_WIFI
        }

        fun isMobileActive(context: Context): Boolean {
            val cm = context
                    .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val info = cm.activeNetworkInfo
            return info != null && info.type == ConnectivityManager.TYPE_MOBILE
        }

        fun isNetwork(context: Context): Boolean {
            return isWifiActive(context) || isMobileActive(context)
        }
    }






}
