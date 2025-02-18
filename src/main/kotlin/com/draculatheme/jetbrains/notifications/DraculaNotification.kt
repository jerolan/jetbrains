package com.draculatheme.jetbrains.notifications

import com.draculatheme.jetbrains.DraculaMeta
import com.intellij.notification.NotificationGroupManager
import com.intellij.notification.NotificationListener
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.IconLoader
import org.intellij.lang.annotations.Language

object DraculaNotification {

    @Language("HTML")
    private val whatsNew = """
        <ul>
            <li>Support JetBrains 2021.3 series</li>
        </ul>
    """.trimIndent()

    @Language("HTML")
    private val footerMessage = """
        <p>Thank you for choosing Dracula.</p>
        <br>
        <p>
            <a href="https://github.com/dracula/jetbrains/blob/master/CHANGELOG.md">Changelog</a> | 
            <a href="https://gumroad.com/a/477820019">Dracula PRO</a> | 
            <a href="https://github.com/dracula/jetbrains">Repository</a>
        </p>
    """.trimIndent()

    @Language("HTML")
    private val releaseNote = """
        <div>
            <h3>What's New?</h3>
            <div>$whatsNew</div>
            <div>$footerMessage</div>
        </div>
    """.trimIndent()

    @Language("HTML")
    private val welcomeMessage = """
        <div>
            $footerMessage
        </div>
    """.trimIndent()

    private const val notificationGroupId = "Dracula Theme"

    @JvmField
    val notificationIcon = IconLoader.getIcon("/icons/dracula-logo.svg", javaClass)

    fun notifyReleaseNote(project: Project) {
        val title = "Dracula Theme updated to v${DraculaMeta.currentVersion}"
        val notification =
            NotificationGroupManager.getInstance().getNotificationGroup(notificationGroupId).createNotification(
                title,
                releaseNote,
                NotificationType.INFORMATION,
                NotificationListener.URL_OPENING_LISTENER
            )
        notification.icon = notificationIcon
        notification.notify(project)
    }

    fun notifyFirstlyDownloaded(project: Project) {
        val title = "Dracula Theme is installed"
        val notification =
            NotificationGroupManager.getInstance().getNotificationGroup(notificationGroupId).createNotification(
                title,
                welcomeMessage,
                NotificationType.INFORMATION,
                NotificationListener.URL_OPENING_LISTENER
            )
        notification.icon = notificationIcon
        notification.notify(project)
    }

}
