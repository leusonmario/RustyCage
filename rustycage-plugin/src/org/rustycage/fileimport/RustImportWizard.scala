package org.rustycage.fileimport

import org.eclipse.jface.wizard.Wizard
import org.eclipse.ui.{IWorkbench, IImportWizard}
import org.eclipse.jface.viewers.IStructuredSelection


class RustImportWizard extends Wizard with IImportWizard {
  var mainPage: RustImportWizardPage = _

  def performFinish(): Boolean = {
    val file = mainPage.createNewFile()
    if (file == null)
      false
    else true
  }

  def init(workbench: IWorkbench, selection: IStructuredSelection) {
    setWindowTitle("Rust File Import Wizard")
    setNeedsProgressMonitor(true)
    mainPage = new RustImportWizardPage("Import Rust File", selection)
  }

  override def addPages() {
    super.addPages()
    addPage(mainPage)
  }

}
