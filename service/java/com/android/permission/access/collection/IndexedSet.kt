/*
 * Copyright (C) 2021 The Android Open Source Project
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

package com.android.permission.access.collection

import android.util.ArraySet

typealias IndexedSet<T> = ArraySet<T>

inline fun <T> IndexedSet<T>.allIndexed(predicate: (Int, T) -> Boolean): Boolean {
    for (index in 0 until size) {
        if (!predicate(index, elementAt(index))) {
            return false
        }
    }
    return true
}

inline fun <T> IndexedSet<T>.anyIndexed(predicate: (Int, T) -> Boolean): Boolean {
    for (index in 0 until size) {
        if (predicate(index, elementAt(index))) {
            return true
        }
    }
    return false
}

@Suppress("NOTHING_TO_INLINE")
inline fun <T> IndexedSet<T>.copy(): IndexedSet<T> = IndexedSet(this)

@Suppress("NOTHING_TO_INLINE")
inline fun <T> IndexedSet<T>.elementAt(index: Int): T = valueAt(index)

inline fun <T> IndexedSet<T>.forEachIndexed(action: (Int, T) -> Unit) {
    for (index in indices) {
        action(index, elementAt(index))
    }
}

inline val <T> IndexedSet<T>.lastIndex: Int
    get() = size - 1

@Suppress("NOTHING_TO_INLINE")
inline operator fun <T> IndexedSet<T>.minusAssign(element: T) {
    remove(element)
}

inline fun <T> IndexedSet<T>.noneIndexed(predicate: (Int, T) -> Boolean): Boolean {
    for (index in 0 until size) {
        if (predicate(index, elementAt(index))) {
            return false
        }
    }
    return true
}

@Suppress("NOTHING_TO_INLINE")
inline operator fun <T> IndexedSet<T>.plusAssign(element: T) {
    add(element)
}

inline fun <T> IndexedSet<T>.removeAllIndexed(predicate: (Int, T) -> Boolean) {
    for (index in lastIndex downTo 0) {
        if (predicate(index, elementAt(index))) {
            removeAt(index)
        }
    }
}

inline fun <T> IndexedSet<T>.retainAllIndexed(predicate: (Int, T) -> Boolean) {
    for (index in lastIndex downTo 0) {
        if (!predicate(index, elementAt(index))) {
            removeAt(index)
        }
    }
}