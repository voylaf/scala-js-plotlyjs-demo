package plotlyjs.demo

import com.raquo.laminar.api.L._
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.openmole.plotlyjs.PlotlyImplicits._
import org.openmole.plotlyjs._
import org.scalajs.dom.html
import plotlyjs.demo.Utils.PlotlyImplicitsAdditional._
import sourcecode.Text

import scala.scalajs.js

/*
 * Copyright (C) 19/06/24 // voylaf@gmail.com
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 */

object ContourDemo {

  val sc: Text[ReactiveHtmlElement[html.Div]] = sourcecode.Text {

    import Contour.contourBuilder
    import ContourDataBuilder.ImplContourDataBuilder

    val data = contourBuilder
    val z = js.Array(
      js.Array(10, 10.625, 12.5, 15.625, 20),
      js.Array(5.625, 6.25, 8.125, 11.25, 15.625),
      js.Array(2.5, 3.125, 5.0, 8.125, 12.5),
      js.Array(0.625, 1.25, 3.125, 6.25, 10.625),
      js.Array(0, 0.625, 2.5, 5.625, 10)
    )

    val dataRef = data
      .z(z)
      .autoContour(true)
      .dx(10)
      .x0(5)
      .dy(10)
      .y0(10)
      //      .contours(Bin.start(0).end(8).size(2))
      .colorScaleContour("Jet")

    val config = Config.displayModeBar(false)

    val layout = Layout
      .title("My contour plot")
      .dragmode(DragMode.select)
      .hovermode(HoverMode.yUnified)
      .height(700)
      .width(700)

    val plotDiv = div()

    Plotly.newPlot(
      plotDiv.ref,
      js.Array(dataRef),
      layout,
      config
    )

    plotDiv
  }

  val elementDemo: ElementDemo = new ElementDemo {
    def title: String = "Contour"

    def code: String = sc.source

    def element: HtmlElement = sc.value
  }
}
