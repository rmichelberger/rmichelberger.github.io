import Navbar from "@/components/Navbar";
import Hero from "@/components/Hero";
import FeaturesGrid from "@/components/FeaturesGrid";
import ToolsShowcase from "@/components/ToolsShowcase";
import AgentsSection from "@/components/AgentsSection";
import PrivacySection from "@/components/PrivacySection";
import ProvidersSection from "@/components/ProvidersSection";
import BetaTestingSection from "@/components/BetaTestingSection";
import DownloadCTA from "@/components/DownloadCTA";
import Footer from "@/components/Footer";

export default function Home() {
  return (
    <>
      <Navbar />
      <main>
        <Hero />
        <FeaturesGrid />
        <ToolsShowcase />
        <AgentsSection />
        <PrivacySection />
        <ProvidersSection />
        <BetaTestingSection />
      </main>
      <Footer />
    </>
  );
}

//          <DownloadCTA />
