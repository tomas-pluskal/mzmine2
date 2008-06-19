/*
 * Copyright 2006-2008 The MZmine Development Team
 * 
 * This file is part of MZmine.
 * 
 * MZmine is free software; you can redistribute it and/or modify it under the
 * terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 * 
 * MZmine is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR
 * A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * MZmine; if not, write to the Free Software Foundation, Inc., 51 Franklin St,
 * Fifth Floor, Boston, MA 02110-1301 USA
 */

package net.sf.mzmine.modules.peakpicking.twostep.peakconstruction;

import net.sf.mzmine.data.Peak;
import net.sf.mzmine.data.RawDataFile;
import net.sf.mzmine.data.Scan;
import net.sf.mzmine.modules.peakpicking.twostep.massdetection.MzPeak;

public interface PeakBuilder {

	/**
	 * 
	 * This method takes all detected MzPeaks in one Scan and try to find a
	 * possible relationship between each one of these with MzPeaks of the
	 * previous scans. It returns an array of objects type Peak.
	 * 
	 * @return Peak[]
	 */
	public Peak[] addScan(Scan scan, MzPeak[] mzValues, RawDataFile dataFile);

	/**
	 * This method creates an array of peaks with all MzPeaks that have not yet
	 * connected. This function must be called after the last scan of the
	 * DataFile.
	 * 
	 * @return Peak[]
	 */
	public Peak[] finishPeaks();

}