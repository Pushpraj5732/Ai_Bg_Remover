import { useUser } from "@clerk/clerk-react";
import { useState } from "react";

function RemoveBg() {
  const { user } = useUser();
  const [file, setFile] = useState(null);
  const [resultImage, setResultImage] = useState(null);

  const API_BASE_URL = import.meta.env.VITE_API_BASE_URL;

  const handleRemoveBg = async () => {
    if (!file) {
      alert("Please select an image");
      return;
    }

    if (!user) {
      alert("Please login first");
      return;
    }

    const formData = new FormData();
    formData.append("image", file);
    formData.append("clerkUserId", user.id);

    try {
      const response = await fetch(
        `${API_BASE_URL}/api/bg/remove`,
        {
          method: "POST",
          body: formData,
        }
      );

      if (!response.ok) {
        throw new Error("Failed to remove background");
      }

      const blob = await response.blob();
      const imageUrl = URL.createObjectURL(blob);
      setResultImage(imageUrl);
    } catch (error) {
      console.error(error);
      alert("Something went wrong");
    }
  };

  return (
    <div>
      <input
        type="file"
        accept="image/*"
        onChange={(e) => setFile(e.target.files[0])}
      />

      <button onClick={handleRemoveBg}>
        Remove Background
      </button>

      {resultImage && (
        <img src={resultImage} alt="Result" width="300" />
      )}
    </div>
  );
}

export default RemoveBg;