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
   Interface for Managing the Network reachability callback result
   Auto-generated implementation of INetworkReachabilityCallback specification.
*/
public class NetworkReachabilityCallbackImpl extends BaseCallbackImpl implements INetworkReachabilityCallback, Serializable {

     /**
        Java serialization support.
        @since 2.2.13
     */
     private static final long serialVersionUID = 100479702L;

     /**
        Constructor with callback id.

        @param id  The id of the callback.
     */
     public NetworkReachabilityCallbackImpl(long id) {
          super(id);
     }

     /**
        No data received - error condition, not authorized .

        @param error Error value
        @since v2.0
     */
     public void onError(INetworkReachabilityCallbackError error) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleNetworkReachabilityCallbackError( '"+getId()+"', Adaptive.INetworkReachabilityCallbackError.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(error)) + "\")) )");
     }

     /**
        Correct data received.

        @param reachable Indicates if the host is reachable
        @since v2.0
     */
     public void onResult(boolean reachable) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleNetworkReachabilityCallbackResult( '"+getId()+"', JSON.parse(\"" + reachable + "\") )");
     }

     /**
        Data received with warning - ie Found entries with existing key and values have been overriden

        @param reachable Indicates if the host is reachable
        @param warning   Warning value
        @since v2.0
     */
     public void onWarning(boolean reachable, INetworkReachabilityCallbackWarning warning) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleNetworkReachabilityCallbackWarning( '"+getId()+"', JSON.parse(\"" + reachable + "\"), Adaptive.INetworkReachabilityCallbackWarning.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(warning)) + "\")) )");
     }

}
/**
------------------------------------| Engineered with ♥ in Barcelona, Catalonia |--------------------------------------
*/
