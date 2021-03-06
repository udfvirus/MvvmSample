/*
 * Copyright (C) 2021 Vitaliy Sychov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.javavirys.mvvmsample.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.ViewCompat
import com.bumptech.glide.Glide
import com.javavirys.mvvmsample.R
import com.javavirys.mvvmsample.core.entity.Channel

class ChannelViewHolder(view: View, private val onClick: (View, Channel) -> Unit) :
    BaseViewHolder<Channel>(view) {

    private val avatarImageView =
        ViewCompat.requireViewById<ImageView>(itemView, R.id.avatarTextView)

    private val channelNameTextView =
        ViewCompat.requireViewById<TextView>(itemView, R.id.channelNameTextView)

    private val channelDescriptionTextView =
        ViewCompat.requireViewById<TextView>(itemView, R.id.channelDescriptionTextView)

    override fun onBind(item: Channel) {
        itemView.setOnClickListener {
            onClick(it, item)
        }
        Glide.with(avatarImageView)
            .load(item.iconId)
            .into(avatarImageView)
        channelNameTextView.text = item.name
        channelDescriptionTextView.text = item.description
    }
}