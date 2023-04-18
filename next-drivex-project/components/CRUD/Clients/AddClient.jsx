import React, { useState } from "react";

export default function AddClient() {

    const [formData, setFormData] = useState({
       client_id: "", 
       name: "",
       email: "",
       age: ""
    });

    const [formSubmitted, setFormSubmitted] = useState(false);

    const handleInputChange = (e) => {
        const {name, value} = e.target;
        setFormData({
            ...formData,
            [name]: value,
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();

        var myHeaders = new Headers();
        myHeaders.append("Content-Type", "application/json");

        let requestOptions = {
            method: 'POST',
            headers: myHeaders,
            body: JSON.stringify(formData),
            redirect: 'follow'
        };

        fetch('https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/client/client', requestOptions)
        .then((response) => response.json())
        .then((data) => {
            console.log(data)
            setFormSubmitted(true);
        }) .catch((error) => {
            console.log(error);
        });
    }
    

    return(
        <React.Fragment>
            <form 
                method="POST" 
                action="https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/client/client"
                onSubmit={handleSubmit}
            >
                <label>
                    Id:
                    <input 
                        type="number"
                        name="client_id"
                        value={formData.client_id}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Name:
                    <input 
                        type="text"
                        name="name"
                        value={formData.name}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Email:
                    <input 
                        type="email"
                        name="email"
                        value={formData.email}
                        onChange={handleInputChange}
                    />
                </label>

                <label>
                    Age:
                    <input 
                        type="number"
                        name="age"
                        value={formData.age}
                        onChange={handleInputChange}
                    />
                </label>

                <button type="submit">Submit</button>
                {formSubmitted ? <p>Reload page</p> : null}
            </form>
        </React.Fragment>
    );
};