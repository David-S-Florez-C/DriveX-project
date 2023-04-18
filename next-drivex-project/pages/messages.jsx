import React, {useState, useEffect} from "react";
import MessageCard from "../components/Cards/Messages/MessageCard";
import AddMessage from "../components/CRUD/Messages/AddMessage";

export default function Messages() {
    const [messageList, setMessageList] = useState([]);

    async function fetchData() {
        try{
            const response = await fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/message/message');
            const data = await response.json()
            
            setMessageList(data.items)
        } catch(error) {
            console.error(error)
        }
    }

    fetchData();

    if(!messageList) {
        return <div>Cargando datos...</div>;
    }

    return(
        <React.Fragment>
            <section>
                <h1>This is the all messages!</h1>
                <article>
                    {messageList.map((message) => (
                        <MessageCard
                            key = {message.message_id}
                            id = {message.message_id}
                            text = {message.message_text}
                        />
                    ))}
                </article>
                <AddMessage />
            </section>
        </React.Fragment>
    );
};