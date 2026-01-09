import { useEffect } from "react";
import { useUser } from "@clerk/clerk-react";

function InitCredits() {
  const { user, isLoaded } = useUser();
  const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;
  useEffect(() => {
    if (!isLoaded || !user) return;

    // call backend once after login
    fetch(`${API_BASE_URL}/api/credits/create/${user.id}`, {
      method: "POST",
    }).catch((err) => {
      console.error("Init credits failed", err);
    });
  }, [isLoaded, user]);

  return null; // 👈 nothing to render
}

export default InitCredits;
