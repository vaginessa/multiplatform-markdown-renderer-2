package com.mikepenz.markdown.compose.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.mikepenz.markdown.utils.findChildOfTypeRecursive
import com.mikepenz.markdown.utils.imagePainter
import org.intellij.markdown.MarkdownElementTypes
import org.intellij.markdown.ast.ASTNode
import org.intellij.markdown.ast.getTextInNode

@Composable
internal fun MarkdownImage(content: String, node: ASTNode) {
    val link = node.findChildOfTypeRecursive(MarkdownElementTypes.LINK_DESTINATION)?.getTextInNode(content)?.toString() ?: return

    Spacer(Modifier.padding(4.dp))

    imagePainter(link)?.let {
        Image(
            painter = it,
            contentDescription = "Markdown Image", // TODO
            contentScale = ContentScale.FillWidth,
            modifier = Modifier.fillMaxWidth()
        )
    }

    Spacer(Modifier.padding(4.dp))
}
