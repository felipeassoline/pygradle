/*
 * Copyright 2016 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linkedin.gradle.python.extension;

import com.linkedin.gradle.python.util.OperatingSystem;
import org.gradle.api.Project;

import java.io.File;


public class ZipappExtension {
    private File cache;
    // Default to fat zipapps on Windows, since our wrappers are fairly POSIX specific.
    private boolean isFat = OperatingSystem.current().isWindows();

    public PexExtension(File cache) {
        this.cache = cache;
    }

    public File getCache() {
        return cache;
    }

    public void setCache(File cache) {
        this.cache = cache;
    }

    /**
     * @return when <code>true</code>, then skinny pex's will be used.
     */
    public boolean isFat() {
        return isFat;
    }

    /**
     * @param fat when <code>true</code>, wrappers will be made all pointing to a single pex file.
     */
    public void setIsFat(boolean isFat) {
        this.isFat = isFat;
    }
}
