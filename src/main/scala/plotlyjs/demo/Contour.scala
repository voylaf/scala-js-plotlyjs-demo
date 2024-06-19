package plotlyjs.demo

import org.openmole.plotlyjs.all.plottype
import org.openmole.plotlyjs.{Bin, PlotData, PlotDataBuilder}

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

object Contour {
  def contourBuilder: PlotDataBuilder = PlotData.set(plottype.contour)
}

@js.native
trait ContourData extends js.Object {
  val autoContour: js.UndefOr[Boolean] = js.native
  val colorScaleContour: js.UndefOr[String] = js.native
  val contours: js.UndefOr[Bin] = js.native
  val dx: js.UndefOr[Double] = js.native
  val x0: js.UndefOr[Double] = js.native
  val dy: js.UndefOr[Double] = js.native
  val y0: js.UndefOr[Double] = js.native
  val autocolorscale: js.UndefOr[Boolean] = js.native
}

object ContourDataBuilder {
  implicit class ImplContourDataBuilder(plotDataBuilder: PlotDataBuilder) {
    def autoContour(v: Boolean): PlotDataBuilder =
      plotDataBuilder.asJsOpt("autocontour", v)
    def colorScaleContour(v: String): PlotDataBuilder =
      plotDataBuilder.asJsOpt("colorscale", v)
    def contours(v: Bin): PlotDataBuilder =
      plotDataBuilder.asJsOpt("contours", v)
    def dx(v: Double): PlotDataBuilder = plotDataBuilder.asJsOpt("dx", v)
    def x0(v: Double): PlotDataBuilder = plotDataBuilder.asJsOpt("x0", v)
    def dy(v: Double): PlotDataBuilder = plotDataBuilder.asJsOpt("dy", v)
    def y0(v: Double): PlotDataBuilder = plotDataBuilder.asJsOpt("y0", v)
    def autocolorscale(v: Boolean): PlotDataBuilder =
      plotDataBuilder.asJsOpt("autocolorscale", v)
  }
}
