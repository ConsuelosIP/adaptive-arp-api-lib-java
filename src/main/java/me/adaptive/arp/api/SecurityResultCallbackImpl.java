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
   Interface for Managing the Security result callback
   Auto-generated implementation of ISecurityResultCallback specification.
*/
public class SecurityResultCallbackImpl extends BaseCallbackImpl implements ISecurityResultCallback, Serializable {

     /**
        Java serialization support.
        @since 2.2.13
     */
     private static final long serialVersionUID = 100432916L;

     /**
        Constructor with callback id.

        @param id  The id of the callback.
     */
     public SecurityResultCallbackImpl(long id) {
          super(id);
     }

     /**
        No data received - error condition, not authorized .

        @param error Error values
        @since v2.0
     */
     public void onError(ISecurityResultCallbackError error) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleSecurityResultCallbackError( '"+getId()+"', Adaptive.ISecurityResultCallbackError.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(error)) + "\")) )");
     }

     /**
        Correct data received.

        @param keyValues key and values
        @since v2.0
     */
     public void onResult(SecureKeyPair[] keyValues) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleSecurityResultCallbackResult( '"+getId()+"', Adaptive.SecureKeyPair.toObjectArray(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(keyValues)) + "\")) )");
     }

     /**
        Data received with warning - ie Found entries with existing key and values have been overriden

        @param keyValues key and values
        @param warning   Warning values
        @since v2.0
     */
     public void onWarning(SecureKeyPair[] keyValues, ISecurityResultCallbackWarning warning) {
          AppRegistryBridge.getInstance().getPlatformContextWeb().executeJavaScript("Adaptive.handleSecurityResultCallbackWarning( '"+getId()+"', Adaptive.SecureKeyPair.toObjectArray(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(keyValues)) + "\")), Adaptive.ISecurityResultCallbackWarning.toObject(JSON.parse(\"" + AppRegistryBridge.escapeString(getJSONParser().toJson(warning)) + "\")) )");
     }

}
/**
------------------------------------| Engineered with ♥ in Barcelona, Catalonia |--------------------------------------
*/
