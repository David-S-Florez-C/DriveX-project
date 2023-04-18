import React, { useState } from "react";
import { useRouter } from "next/router";
import DeleteClient from "../../components/CRUD/Clients/DeleteClient";
import PutClient from "../../components/CRUD/Clients/PutClient";

export default function ClientItem() {
    const [client, setClient] = useState([]);
    
    const { query: { clientId }, } = useRouter();

    async function fetchData() {
        try {
            const response = await fetch(`https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/client/client/${clientId}`)
            const data = await response.json();
            setClient(data.items);
        } catch(error) {
            console.log(error);
        }
    }

    fetchData();
    

    return(
        <React.Fragment>
            <section>
                <h1>This is the client: {clientId}</h1>
                {client?.map((client) => (
                    <div key = {client.client_id}>
                        <picture>
                            <img src = "" alt = {`Image ${client.client_id}`} />
                        </picture>
                        <div>
                            <h5>{client.name}</h5>
                            <p>{client.email}</p>
                            <p>{client.age}</p>
                        </div>
                    </div>
                ))}
                <DeleteClient clientId={clientId} />
                <PutClient />
            </section>
        </React.Fragment>
    );
};