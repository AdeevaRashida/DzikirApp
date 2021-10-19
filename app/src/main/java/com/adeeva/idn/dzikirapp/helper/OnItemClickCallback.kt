package com.adeeva.idn.dzikirapp.helper

import com.adeeva.idn.dzikirapp.model.Artikel

interface OnItemClickCallback {
    fun onItemClicked(data: Artikel)
}