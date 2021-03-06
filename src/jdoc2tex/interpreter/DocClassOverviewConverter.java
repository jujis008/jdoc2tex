package jdoc2tex.interpreter;

import jdoc2tex.layout.DocTableManager;
import jdoc2tex.layout.ITableManager;
import jdoc2tex.layout.TexFontSize;

import com.sun.javadoc.ClassDoc;

public class DocClassOverviewConverter extends AbstractDocConverter {

	@Override
	public String interpretConverter(ClassDoc classDoc) {
		ITableManager table = new DocTableManager(1);

		table.addRow("");
		table.addRow(TexFontSize.SCRIPTSIZE,escape(classDoc.containingPackage().name()
				+ "\\\\ \\large Class " + escape(classDoc.name())));
		table.addRow(par(classDoc.commentText()));

		table.enableTopMargin();

		return table.generateTable();
	}

}
