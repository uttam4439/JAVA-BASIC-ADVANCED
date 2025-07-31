const jwt = require("jsonwebtoken");
const fs = require("fs");

try {
  console.log("Reading private key...");
  const privateKey = fs.readFileSync("AuthKey_L88MQ8P7RC.p8");

  console.log("Signing token...");
  const token = jwt.sign({}, privateKey, {
    algorithm: "ES256",
    expiresIn: "180d",
    issuer: "73B8W4ZN6V",
    audience: "https://appleid.apple.com",
    subject: "com.anumodya.ksuvp",
    keyid: "L88MQ8P7RC",
  });

  console.log("\n✅ Generated Token:\n");
  console.log(token);
} catch (error) {
  console.error("❌ Error generating JWT:", error);
}
