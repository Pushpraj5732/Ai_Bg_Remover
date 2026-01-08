import { useEffect, useState } from "react";

function Credits({ clerkUserId }) {
  const [credits, setCredits] = useState(null);

  // ✅ 1️⃣ CREATE USER ON FIRST LOGIN
  useEffect(() => {
    if (!clerkUserId) return;

    fetch(`http://localhost:8080/api/credits/create/${clerkUserId}`, {
      method: "POST",
    }).catch(console.error);
  }, [clerkUserId]);

  // ✅ 2️⃣ FETCH CREDITS
  useEffect(() => {
    if (!clerkUserId) return;

    fetch(`http://localhost:8080/api/credits/${clerkUserId}`)
      .then(async (res) => {
        if (!res.ok) {
          const err = await res.json();
          throw new Error(err.error || "Failed to fetch credits");
        }
        return res.json();
      })
      .then((data) => setCredits(data))
      .catch((err) => {
        console.error(err);
        setCredits(0); // fallback
      });
  }, [clerkUserId]);

  // ⏳ Loading
  if (credits === null) return <p>Loading credits...</p>;

  // ✅ UI
  return (
    <div className="p-2 text-sm">
      <span>
        Credits: <b>{typeof credits === "number" ? credits : 0}</b>
      </span>
    </div>
  );
}

export default Credits;
