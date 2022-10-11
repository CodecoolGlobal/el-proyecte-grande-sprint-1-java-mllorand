import React, {useEffect, useState} from 'react';
import User from "./user_components/User";
import CooperatorDetails from "./cooperator_components/CooperatorDetails";
import useFetch from "./useFetch";

const Profile = () => {
    const {data: profile, isPending, error} = useFetch('http://localhost:8080/profile/2')

    const [userData, setUserData] = useState(null)
    const [cooperatorData, setCooperatorData] = useState(null)

    useEffect(
        () => {
            if (!isPending) {
                setUserData(
                    {
                        id: profile.id,
                        userName: profile.userName,
                        emailAddress: profile.emailAddress,
                        fullName: profile.fullName,
                        age: profile.age,
                        gender: profile.gender
                    }
                )
                setCooperatorData(
                    {
                        id: profile.id,
                        strengths: profile.strengths,
                        learnt: profile.learnt,
                        interested: profile.interested,
                        learnFromScratch: profile.learnFromScratch,
                        improveIn: profile.improveIn
                    }
                )
            }
        }, [isPending]
    )


    return (
        <>
            {error && <div>{error}</div>}
            {isPending && <div>{isPending}</div>}
            {userData && cooperatorData &&
                <article id="profile-content">
                    <aside id="user-details-content">
                        <User user={userData}/>
                    </aside>
                    <main id="cooperator-details-content">
                        <CooperatorDetails cooperator={cooperatorData}/>
                    </main>
                </article>
            }
        </>
    );
};

export default Profile;
