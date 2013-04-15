/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.ultradns.ws.xml;

import static org.jclouds.util.SaxUtils.equalsOrSuffix;

import org.jclouds.http.functions.ParseSax;
import org.jclouds.ultradns.ws.domain.DirectionalGroup;
import org.jclouds.ultradns.ws.domain.DirectionalGroup.Builder;
import org.xml.sax.Attributes;

import com.google.common.base.Splitter;

/**
 * 
 * @author Adrian Cole
 */
public class DirectionalGroupNameAndRegionsHandler extends ParseSax.HandlerForGeneratedRequestWithResult<DirectionalGroup> {

   private final Builder group = DirectionalGroup.builder();

   @Override
   public DirectionalGroup getResult() {
      return group.build();
   }

   @Override
   public void startElement(String url, String name, String qName, Attributes attrs) {
      if (equalsOrSuffix(qName, "DirectionalDNSGroupDetail")) {
         group.name(attrs.getValue("GroupName"));
      } else if (equalsOrSuffix(qName, "RegionForNewGroups")) {
         String regionName = attrs.getValue("RegionName");
         Iterable<String> territories = Splitter.on(';').split(attrs.getValue("TerritoryName"));
         group.mapRegionToTerritories(regionName, territories);
      }
   }
}
