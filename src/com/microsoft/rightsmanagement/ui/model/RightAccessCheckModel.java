/**
 * Copyright � Microsoft Corporation, All Rights Reserved
 *
 * Licensed under MICROSOFT SOFTWARE LICENSE TERMS, 
 * MICROSOFT RIGHTS MANAGEMENT SERVICE SDK UI LIBRARIES;
 * You may not use this file except in compliance with the License.
 * See the license for specific language governing permissions and limitations.
 * You may obtain a copy of the license (RMS SDK UI libraries - EULA.DOCX) at the 
 * root directory of this project.
 *
 * THIS CODE IS PROVIDED *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION
 * ANY IMPLIED WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A
 * PARTICULAR PURPOSE, MERCHANTABILITY OR NON-INFRINGEMENT.
 */

package com.microsoft.rightsmanagement.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Models Right Access Check.
 */
public class RightAccessCheckModel implements Parcelable
{
    public static final Parcelable.Creator<RightAccessCheckModel> CREATOR = new Creator<RightAccessCheckModel>()
    {
        @Override
        public RightAccessCheckModel createFromParcel(Parcel in)
        {
            return new RightAccessCheckModel(in);
        }

        @Override
        public RightAccessCheckModel[] newArray(int size)
        {
            return new RightAccessCheckModel[size];
        }
    };
    private boolean mHasAccess;
    private String mRightName;

    /**
     * Instantiates a new right access check model.
     * 
     * @param localizedRightName the localized message
     * @param hasAccess the has access
     */
    public RightAccessCheckModel(String localizedRightName,
                                 boolean hasAccess)
    {
        mRightName = localizedRightName;
        mHasAccess = hasAccess;
    }

    /**
     * Instantiates a new right access check model.
     * 
     * @param in the in
     */
    private RightAccessCheckModel(Parcel in)
    {
        mRightName = in.readString();
        mHasAccess = in.readByte() != 0;
    }

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#describeContents()
     */
    @Override
    public int describeContents()
    {
        return 0;
    }

    /**
     * Gets the checks for access.
     * 
     * @return the checks for access
     */
    public boolean getHasAccess()
    {
        return mHasAccess;
    }

    /**
     * Gets the right name.
     * 
     * @return the right name
     */
    public String getRightName()
    {
        return mRightName;
    }

    /*
     * (non-Javadoc)
     * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
     */
    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(mRightName);
        out.writeByte((byte)(mHasAccess ? 1 : 0));
    }
}
