export default function deleteCVById(id){
    var requestOptions = {
        method: 'DELETE',
        credentials: 'include',
        redirect: 'follow'

    };
    fetch(`${process.env.uri}/api/cvs/${id}`, requestOptions)
    .then(response => {return response.json()})
    .catch(error => console.log('error', error));
}