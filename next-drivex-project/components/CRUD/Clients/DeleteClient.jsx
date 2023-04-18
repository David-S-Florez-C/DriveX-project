import React from "react";
import { useRouter } from "next/router";

export default function DeleteClient(props) {

    const router = useRouter();

    function deleteData() {
        let requestOptions = {
            method: 'DELETE',
            redirect: 'follow'
        };

        try {
            fetch(`https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/client/client?client_id=${props.clientId}`, requestOptions)
            router.push("/clients")
        } catch(error) {
            console.error(error);
        }
    }
    

    return(
        <React.Fragment>
            <button onClick={deleteData}>Delete</button>
        </React.Fragment>
    );
};