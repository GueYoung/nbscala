package org.netbeans.modules.scala.sbt.project

import java.beans.PropertyChangeListener
import javax.swing.Icon
import javax.swing.ImageIcon
import org.netbeans.api.project.Project
import org.netbeans.api.project.ProjectInformation
import org.netbeans.spi.project.ProjectState
import org.openide.filesystems.FileObject
import org.openide.util.ImageUtilities
import org.openide.util.Lookup
import org.openide.util.lookup.Lookups

/**
 * 
 * @author Caoyuan Deng
 */
class SBTProject(projectDir: FileObject, state: ProjectState) extends Project {
  private val SBT_ICON = "org/netbeans/modules/scala/sbt/resources/scala16x16.png"
  
  private lazy val lookup: Lookup = Lookups.fixed(Array[AnyRef](
      new Info()      
    )
  )

  override
  def getProjectDirectory = projectDir

  override
  def getLookup: Lookup = {
    lookup
  }
  
  private final class Info extends ProjectInformation {

    override
    def getIcon: Icon = new ImageIcon(ImageUtilities.loadImage(SBTProject.SBT_ICON))

    override
    def getName: String = {
      getProjectDirectory.getName
    }

    override
    def getDisplayName: String = {
      getName
    }

    override
    def addPropertyChangeListener(pcl: PropertyChangeListener) {
      //do nothing, won't change
    }

    override
    def removePropertyChangeListener(pcl: PropertyChangeListener) {
      //do nothing, won't change
    }

    override
    def getProject: Project = SBTProject.this
  }
}

object SBTProject {
  private val SBT_ICON = "org/netbeans/modules/scala/sbt/resources/scala16x16.png"
}