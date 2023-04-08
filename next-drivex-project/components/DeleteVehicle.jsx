'use client'
import { useRouter } from 'next/navigation';
export function DeleteVehicle({id}) {
    const {push} = useRouter();
    console.log(id);


    const deleteVehicle = () => {
        const params = {car_id: id};
        const url = `https://g4932924a17736e-ca5bxc3sr3p4rtcw.adb.us-chicago-1.oraclecloudapps.com/ords/admin/car/car?${new URLSearchParams(params)}`;
        const options = {
            method: 'DELETE'
        };
        fetch(url, options)
            .then(response => {
              // Manejar la respuesta del servidor
              response.status == 204 ? push('/vehicles') : console.error('no se pudo eliminar')
            })
            .catch(error => {
              // Manejar el error
            });
        
        
    } 

    return(
        <button onClick={deleteVehicle}></button>
    );
}