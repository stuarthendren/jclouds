/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.elastichosts;

import static org.jclouds.compute.config.ComputeServiceProperties.TEMPLATE;

import java.net.URI;
import java.util.Properties;

import org.jclouds.elasticstack.ElasticStackApiMetadata;
import org.jclouds.providers.ProviderMetadata;
import org.jclouds.providers.internal.BaseProviderMetadata;

import com.google.auto.service.AutoService;

/**
 * Implementation of {@link ProviderMetadata} for ElasticHosts Miami.
 */
@AutoService(ProviderMetadata.class)
public class ElasticHostsMiamiMetadata extends BaseProviderMetadata {

   public static Builder builder() {
      return new Builder();
   }

   @Override
   public Builder toBuilder() {
      return builder().fromProviderMetadata(this);
   }

   public ElasticHostsMiamiMetadata() {
      super(builder());
   }

   public ElasticHostsMiamiMetadata(Builder builder) {
      super(builder);
   }

   public static Properties defaultProperties() {
      Properties properties = new Properties();
      properties.setProperty(TEMPLATE, "osFamily=UBUNTU,osVersionMatches=1[01234].[01][04].?[0-9]?,os64Bit=true");
      return properties;
   }

   public static class Builder extends BaseProviderMetadata.Builder {

      protected Builder() {
         id("elastichosts-mmi-a").name("ElasticHosts Miami")
               .apiMetadata(new ElasticStackApiMetadata().toBuilder().version("2.0").build())
               .homepage(URI.create("https://mmi-a.elastichosts.com"))
               .console(URI.create("https://mmi-a.elastichosts.com/accounts"))
               .iso3166Codes("US-FL")
               .endpoint("https://api-mmi-a.elastichosts.com")
               .defaultProperties(ElasticHostsMiamiMetadata.defaultProperties());
      }

      @Override
      public ElasticHostsMiamiMetadata build() {
         return new ElasticHostsMiamiMetadata(this);
      }

      @Override
      public Builder fromProviderMetadata(ProviderMetadata in) {
         super.fromProviderMetadata(in);
         return this;
      }

   }
}
