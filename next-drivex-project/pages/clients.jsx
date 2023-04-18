import React, {useState, useEffect} from "react";
import ClientCard from "../components/Cards/Clients/ClientCard";
import AddClient from "../components/CRUD/Clients/AddClient";

export default function Clients() {
    const [clientList, setClientList] = useState([]);

    async function fetchData() {
        try{
            const response = await fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/client/client');
            const data = await response.json()
            
            setClientList(data.items)
        } catch(error) {
            console.error(error)
        }
    }

    fetchData();

    if(!clientList) {
        return <div>Cargando datos...</div>;
    }

    return(
        <React.Fragment>
            <section>
                <h1>This is the all clients!</h1>
                <article>
                    {clientList.map((client) => (
                        <ClientCard
                            key = {client.client_id}
                            id = {client.client_id}
                            name = {client.name}
                            email = {client.email}
                            age = {client.age}
                        />
                    ))}
                </article>
                <AddClient />
            </section>
        </React.Fragment>
    );
};