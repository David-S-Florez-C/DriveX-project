  // Imports
// Librarys
// Components
import { Header } from "@/components/Header/Header"

export const metadata = {
  title: 'DriveX',
  description: 'Discover the road with DriveX',
}
 
export default function RootLayout({ children }) {
 return (
    <html lang="en">
      <body>
        <Header />
        {children}
        </body>
    </html>
  )
}