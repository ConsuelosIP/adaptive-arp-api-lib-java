/**
--| ADAPTIVE RUNTIME PLATFORM |----------------------------------------------------------------------------------------

(C) Copyright 2013-2015 Carlos Lozano Diez t/a Adaptive.me <http://adaptive.me>.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 . Unless required by appli-
-cable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,  WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the  License  for the specific language governing
permissions and limitations under the License.

Original author:

    * Carlos Lozano Diez
            <http://github.com/carloslozano>
            <http://twitter.com/adaptivecoder>
            <mailto:carlos@adaptive.me>

Contributors:

    * Ferran Vila Conesa
             <http://github.com/fnva>
             <http://twitter.com/ferran_vila>
             <mailto:ferran.vila.conesa@gmail.com>

    * See source code files for contributors.

Release:

    * @version v2.2.15

-------------------------------------------| aut inveniam viam aut faciam |--------------------------------------------
*/

package me.adaptive.arp.api;

import com.google.gson.Gson;
import java.io.Serializable;

/**
   Interface for Managing the Services operations
   Auto-generated implementation of IServiceResultCallback specification.
*/
public class ServiceResultCallbackImpl extends BaseCallbackImpl implements IServiceResultCallback, Serializable {

     /**
        Java serialization support.
        @since 2.2.13
     */
     private static final long serialVersionUID = 100415255L;

     /**
        Constructor with callback id.

        @param id  The id of the callback.
     */
     public ServiceResultCallbackImpl(long id) {
          super(id);
     }

     /**
        This method is called on Error

        @param error returned by the platform
        @since v2.0
     */
     public void onError(IServiceResultCallbackError error) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleServiceResultCallbackError( '"+getId()+"', Adaptive.IServiceResultCallbackError.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(error)) + "\")) )");
     }

     /**
        This method is called on Result

        @param response data
        @since v2.0
     */
     public void onResult(ServiceResponse response) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleServiceResultCallbackResult( '"+getId()+"', Adaptive.ServiceResponse.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(response)) + "\")) )");
     }

     /**
        This method is called on Warning

        @param response data
        @param warning  returned by the platform
        @since v2.0
     */
     public void onWarning(ServiceResponse response, IServiceResultCallbackWarning warning) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleServiceResultCallbackWarning( '"+getId()+"', Adaptive.ServiceResponse.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(response)) + "\")), Adaptive.IServiceResultCallbackWarning.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(warning)) + "\")) )");
     }

}
/**
------------------------------------| Engineered with ♥ in Barcelona, Catalonia |--------------------------------------
*/
